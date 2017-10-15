# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# TODO: Update hard-coded info with variables

# Sets the minimum version of CMake required to build the native library.

set(CMAKE_VERBOSE_MAKEFILE 1) # Use 1 for debugging, 0 for release
cmake_minimum_required(VERSION 3.4.1)

# Note: One could use a 'GLOB' here, but newly added source files won't auto-regen build files
set(SOURCE_FILES
    src/main/cpp/SeePlusPlus.cpp
    )

# Include a location to the header files
include_directories(src/main/cpp)

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

add_library( # Sets the name of the library.
             SeePlusPlus

             # Sets the library as a shared library.
             SHARED

             # Provides the list of files to compile.
             ${SOURCE_FILES} )

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
              log-lib

              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log )

# Fail the build if SWIG is not found - Ensure SWIG is installed and on the system path

find_package(SWIG REQUIRED)
include(${SWIG_USE_FILE})

# Ensure file recognized as C++ (otherwise, exported as C file)

set_property(SOURCE src/main/cpp/SeePlusPlus.i PROPERTY CPLUSPLUS ON)

# Setup SWIG flags and locations

set(CMAKE_SWIG_FLAGS -c++ -package com.sureshjoshi.core)
set(CMAKE_SWIG_OUTDIR ${Project_SOURCE_DIR}/src/main/cpp/wrapper)

# Export a wrapper file to Java, and link with the created C++ library

swig_add_module(SeePlusPlus_Wrapper java src/main/cpp/SeePlusPlus.i)
swig_link_libraries(SeePlusPlus_Wrapper SeePlusPlus)

#

file(GLOB JAVA_FILES ${Project_SOURCE_DIR}/src/main/cpp/wrapper/*.java)
if (${JAVA_FILES})
    file(COPY ${JAVA_FILES}
         DESTINATION ${Project_SOURCE_DIR}/src/main/java/com/sureshjoshi/core)
    file(remove ${JAVA_FILES})
endif()

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
                       SeePlusPlus

                       # Links the target library to the log library
                       # included in the NDK.
                       ${log-lib} )