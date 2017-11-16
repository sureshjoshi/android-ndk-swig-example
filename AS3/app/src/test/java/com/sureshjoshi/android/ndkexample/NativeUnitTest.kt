package com.sureshjoshi.android.ndkexample

import org.junit.Assert
import org.junit.Test
import java.io.File

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class NativeUnitTest {
    @Test
    fun addition_isCorrect() {
        // TODO: Read this directory from Gradle
        val wrapperLib = File("app/.externalNativeBuild/cmake/debug/osx/libSeePlusPlus_Wrapper.jnilib")
        System.out.println(wrapperLib.absolutePath)
        System.load(wrapperLib.absolutePath)
        val mCpp = SeePlusPlus()
        val result = mCpp.Multiply(5, 1)
        Assert.assertEquals(5, result)
    }
}
