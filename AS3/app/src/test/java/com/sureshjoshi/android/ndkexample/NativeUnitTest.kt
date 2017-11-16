package com.sureshjoshi.android.ndkexample

import com.sureshjoshi.core.SeePlusPlus
import org.junit.Assert
import org.junit.Test
import java.io.File

class NativeUnitTest {
    @Test
    fun nativeMultiply_isCorrect() {
        // TODO: Read this directory from Gradle
        val wrapperLib = File("app/.externalNativeBuild/cmake/debug/osx/libSeePlusPlus_Wrapper.jnilib")
        System.out.println(wrapperLib.absolutePath)
        System.load(wrapperLib.absolutePath)
        val mCpp = SeePlusPlus()
        val result = mCpp.Multiply(5, 1)
        Assert.assertEquals(5, result)
    }
}
