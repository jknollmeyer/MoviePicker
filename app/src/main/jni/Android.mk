LOCAL_PATH := $(call my-dir)
LOCAL_MODULE := moviepicker
LOCAL_SRC_FILES := MoviePicker.cpp \
                    userinput.cpp
LOCAL_LDLIBS := -llog
include $(BUILD_SHARED_LIBRARY)