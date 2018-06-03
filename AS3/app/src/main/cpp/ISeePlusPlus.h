#ifndef __SJ_ISEEPLUSPLUS_H__
#define __SJ_ISEEPLUSPLUS_H__

#include <string>
#include <vector>
#include "ISeePlusPlusInterface.h"

/**
 *  @file 
 */
namespace SJ {
/**
 *  @class ISeePlusPlus
 *  @brief
 */
    class ISeePlusPlus {
    public:

        /**
        * Destructor.
        */
        virtual ~ISeePlusPlus() {}

        /**
         * A method that takes in two integers and returns the result of multiplying them together
         *
         * @param[in] x Signed integer to multiply with.
         * @param[in] y Signed integer to multiply with.
         * @return The result of multiplying the two inputs
         */
        virtual int Multiply(const int x, const int y)=0;

        /**
         * A method that takes in two integers and returns the result of multiplying them together
         *
         * @param[in] x Double to multiply with.
         * @param[in] y Double to multiply with.
         * @return The result of multiplying the two inputs
         */
        virtual double Multiply(const double x, const double y)=0;

        /**
         * A method that internally creates a vector of random numbers and returns them
         *
         * @param[in] size The size of the vector to return
         * @return std::vector<std::string> An unsorted list of random numbers.
         */
        virtual std::vector<int> RandomNumbers(const int size)=0;

        /**
         * A method that takes in a vector of strings, and sorts them, and returns a sorted copy
         *
         * @param[in] inStringList A vector of strings to be sorted
         * @return std::vector<std::string> An alphabetically sorted list of strings.
         */
        virtual std::vector<std::string> Sort(const std::vector<std::string> &inStrings)=0;

        virtual void returnViaCallback(const std::string input, ISeePlusPlusInterface * callbackInterface)=0;

    }; // class ISeePlusPlus

} // namespace SJ
#endif // __SJ_ISEEPLUSPLUS_H__