
import 'package:flutter/material.dart';

enum ScreenSize {
  unknown,
  xxsmall,
  xsmall,
  small,
  medium,
  large,
  xlarge
}

class ResponsiveUtil {

  static const BREAK_POINT_PIXEL_X_LARGE  = 1900;
  static const BREAK_POINT_PIXEL_LARGE    = 1200;
  static const BREAK_POINT_PIXEL_MEDIUM   = 992;
  static const BREAK_POINT_PIXEL_SMALL    = 768;
  static const BREAK_POINT_PIXEL_X_SMALL  = 480;
  static const BREAK_POINT_PIXEL_XX_SMALL = 320;

  static bool isScreenXLargeByContext(BuildContext context)  => isScreenXLarge(MediaQuery.of(context));
  static bool isScreenLargeByContext(BuildContext context)  => isScreenLarge(MediaQuery.of(context));
  static bool isScreenMediumByContext(BuildContext context) => isScreenMedium(MediaQuery.of(context));
  static bool isScreenSmallByContext(BuildContext context) => isScreenSmall(MediaQuery.of(context));
  static bool isScreenXSmallByContext(BuildContext context) => isScreenXSmall(MediaQuery.of(context));
  static bool isScreenXXSmallByContext(BuildContext context) => isScreenXXSmall(MediaQuery.of(context));
  
  static bool isScreenXLarge(MediaQueryData mediaQueryData) => mediaQueryData.size.width >= BREAK_POINT_PIXEL_X_LARGE;
  static bool isScreenLarge(MediaQueryData mediaQueryData) => mediaQueryData.size.width >= BREAK_POINT_PIXEL_LARGE;
  static bool isScreenMedium(MediaQueryData mediaQueryData) => mediaQueryData.size.width >= BREAK_POINT_PIXEL_MEDIUM;
  static bool isScreenSmall(MediaQueryData mediaQueryData) => mediaQueryData.size.width >= BREAK_POINT_PIXEL_SMALL;
  static bool isScreenXSmall(MediaQueryData mediaQueryData) => mediaQueryData.size.width >= BREAK_POINT_PIXEL_X_SMALL;
  static bool isScreenXXSmall(MediaQueryData mediaQueryData) => mediaQueryData.size.width >= BREAK_POINT_PIXEL_XX_SMALL;

  static double padding() {
    //final screen = screenSize(mediaQueryData);
    //switch (screen) {
    //  case ScreenSize.xlarge:  return 48;
    //  case ScreenSize.large:   return 32;
    //  case ScreenSize.medium:  return 24;
    //  case ScreenSize.small:   return 16;
    //  case ScreenSize.xsmall:  return 8;
    //  case ScreenSize.xxsmall: return 4;
    //  default:
    //}
    return 16;
  }

  static ScreenSize screenSize(MediaQueryData mediaQueryData) {
    if (mediaQueryData.size.width >= BREAK_POINT_PIXEL_X_LARGE) {
      return ScreenSize.xlarge;
    } else if (mediaQueryData.size.width >= BREAK_POINT_PIXEL_LARGE) {
      return ScreenSize.large;
    } else if (mediaQueryData.size.width >= BREAK_POINT_PIXEL_MEDIUM) {
      return ScreenSize.medium;
    } else if (mediaQueryData.size.width >= BREAK_POINT_PIXEL_SMALL) {
      return ScreenSize.small;
    } else if (mediaQueryData.size.width >= BREAK_POINT_PIXEL_X_SMALL) {
      return ScreenSize.xsmall;
    } else if (mediaQueryData.size.width >= BREAK_POINT_PIXEL_XX_SMALL) {
      return ScreenSize.xxsmall;
    }
    return ScreenSize.unknown;
  }
}