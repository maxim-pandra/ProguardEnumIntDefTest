#With or without thouse settings, proguard refuses to convert enum to int

# For enumeration classes, see http://proguard.sourceforge.net/manual/examples.html#enumerations
#-optimizationpasses 5
#
#-keepclassmembers enum * {
#    public static **[] values();
#    public static ** valueOf(java.lang.String);
#}