package com.pizza11x.androidmvvmarchitecture

import com.pizza11x.androidmvvmarchitecture.data.network.MockInterceptor

import android.content.Context
import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockkStatic
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.rules.TestRule

open class OBaseTest {

    @get:Rule
    val rule: TestRule = InstantTaskExecutorRule()

    lateinit var testLifeCycleOwner: TestLifeCycleOwner

    @MockK
    lateinit var context: Context
    lateinit var mockInterceptor: MockInterceptor

    @Before
    fun setUp() {

        MockKAnnotations.init(this)

        mockkStatic(Log::class)
        every { Log.v(any(), any()) } returns 0
        every { Log.d(any(), any()) } returns 0
        every { Log.i(any(), any()) } returns 0
        every { Log.e(any(), any()) } returns 0

        mockInterceptor = MockInterceptor(context, runUnitTest = true)
        testLifeCycleOwner = TestLifeCycleOwner()
        testLifeCycleOwner.onCreate()
    }

    @After
    fun tearDown() {
        testLifeCycleOwner.onDestroy()
    }
}
