package Entity;

import Utils.RatingFilterType;

public class FilterPermissions {
    private static RatingFilterType defaultFilter = RatingFilterType.RATINGS;
    private static boolean accessRatingsFilter = true;
    private static boolean accessSalesFilter = false;

    public static RatingFilterType getDefaultFilter() {
        return defaultFilter;
    }


    public static boolean isAccessRatingsFilter() {
        return accessRatingsFilter;
    }



    public static boolean isAccessSalesFilter() {
        return accessSalesFilter;
    }

    public static void setDefaultFilter(RatingFilterType defaultFilter) {
        FilterPermissions.defaultFilter = defaultFilter;
    }

    public static void setAccessRatingsFilter(boolean accessRatingsFilter) {
        FilterPermissions.accessRatingsFilter = accessRatingsFilter;
    }

    public static void setAccessSalesFilter(boolean accessSalesFilter) {
        FilterPermissions.accessSalesFilter = accessSalesFilter;
    }
}
