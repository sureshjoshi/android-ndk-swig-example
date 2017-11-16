# android-ndk-swig-example
This project has full examples of using Android Studio(s) 1, 2, and 3, Gradle, CMake, the Android NDK, and SWIG to automatically compile and setup C++ libraries and Java wrappers.

Explained in detail here: http://www.sureshjoshi.com/mobile/android-ndk-in-android-studio-with-swig/ (pending updates to include CMake)

## Android Studio 2/3

Since Android Studio 2.2, CMake and the NDK have a higher status in the Android ecosystem, so Gradle hacks are no longer necessary. The only dependency is:

* [SWIG](http://www.swig.org/) - Which needs to be on your system path too, so CMake can pick it up

SWIG is setup in the CMakeLists.txt file, so you only need to setup the correct directories and source files.

A common problem with auto-generated code in CMake is that Android Studio will not run the CMake-related commands until AFTER it tries to search through all files. In this repo, that let to a failing build caused by a missing `com.sureshjoshi.core` package. The manual workaround was to call:

```
./gradle externalNativeBuildDebug
```

in the terminal to generate the missing C++ wrapper files. 

Now, there is a Gradle hack which will call externalNativeBuild during Gradle's pre-compilation phase, which means that Swig is ALWAYS run before AS looks for Java files. 

For information about junit testing native libraries, please refer to the feature branch "9-junit-native" which has a working implementation for OSx. 

## Android Studio 1

Here are the from-scratch build steps (if you were going to build in your home directory on Linux/Mac - similar for Windows, with slightly revised commands and locations):

    cd ~/
    git clone https://github.com/sureshjoshi/android-ndk-swig-example.git
    [Open in Android Studio and let Gradle run and the project get indexed - this creates local.properties and the sdk.dir]
    cd android-ndk-swig-example/NDKExample
    ./gradlew runSwig
    (In Android Studio) Make Project

That should build error-free (assuming you’ve set up your ndk.dir in local.properties).

The dependencies are:

* [Android Studio (1.0+)](https://developer.android.com/tools/studio/index.html)
* [Gradle Tools (1.0+)](https://developer.android.com/tools/studio/index.html#build-system)
* [Android NDK](https://developer.android.com/tools/sdk/ndk/index.html)
* [SWIG](http://www.swig.org/)


License
-------

	The MIT License (MIT)

	Copyright (c) 2017 Suresh Joshi

	Permission is hereby granted, free of charge, to any person obtaining a copy
	of this software and associated documentation files (the "Software"), to deal
	in the Software without restriction, including without limitation the rights
	to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
	copies of the Software, and to permit persons to whom the Software is
	furnished to do so, subject to the following conditions:

	The above copyright notice and this permission notice shall be included in all
	copies or substantial portions of the Software.

	THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
	IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
	FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
	AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
	LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
	OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
	SOFTWARE.
