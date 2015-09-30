# android-ndk-swig-example
This project is a full example of using Android Studio (1.0+), Gradle (1.0+), NDK, and SWIG to automatically compile and setup C++ libraries and Java wrappers in Android Studio.

Explained in detail here: http://www.sureshjoshi.com/mobile/android-ndk-in-android-studio-with-swig/

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

	Copyright (c) 2015 Suresh Joshi

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
