#ifndef _ISEEPLUSPLUSINTERFACE_H__
#define _ISEEPLUSPLUSINTERFACE_H__

#include <string>

//namespace SJ {

    struct ISeePlusPlusInterface {
        virtual ~ISeePlusPlusInterface() {}

        virtual void print(const std::string &text) = 0;
    };
//}

#endif // _ISEEPLUSPLUSINTERFACE_H__