LOCAL_PATH := $(call my-dir)

#Build .so  
include $(CLEAR_VARS)

LOCAL_MODULE := libIRCore
LOCAL_SRC_FILES_64 := libs/arm64-v8a/libIRCore.so
LOCAL_MULTILIB := 64
LOCAL_MODULE_CLASS := SHARED_LIBRARIES
LOCAL_MODULE_SUFFIX := .so

include $(BUILD_PREBUILT)

#-----------------------------------------------------

include $(CLEAR_VARS)

LOCAL_MODULE_TAGS := optional

LOCAL_PACKAGE_NAME := FactoryTest
LOCAL_SRC_FILES := $(call all-java-files-under, src)
LOCAL_RESOURCE_DIR := $(LOCAL_PATH)/res
LOCAL_ASSET_DIR := $(LOCAL_PATH)/assets

LOCAL_STATIC_JAVA_LIBRARIES := android-support-v4
LOCAL_JNI_SHARED_LIBRARIES := libIRCore

LOCAL_MULTILIB := 64

LOCAL_PROGUARD_ENABLED := disabled

include $(BUILD_PACKAGE)	
