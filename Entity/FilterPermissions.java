package Entity;

import Utils.RatingFilterType;

/**
 * Represents a filtering algorithim in the MOBLIMA app
 * @author htut
 * @version 1.0
 * @since 2022-11-12
 */
public class FilterPermissions {

    /**
     * Whether the rating filters can be accessed
     */
    private static boolean accessRatingsFilter = true;
    /**
     * Whether the sales filters can be accessed
     */
    private static boolean accessSalesFilter = false;

    /**
     * Determines if the ratings filter can be accessed
     * @return the boolean value, true means can be accessed
     */
    public static boolean isAccessRatingsFilter() {
        return accessRatingsFilter;
    }

    /**
     * Determines if the sales filter can be accessed
     * @return the boolean value, true means can be accessed
     */
    public static boolean isAccessSalesFilter() {
        return accessSalesFilter;
    }

    /**
     * Changes the boolean value of accessRatingsFilter to determine if ratings filter can be accessed
     * @param accessRatingsFilter the current accessibility of ratings filter
     */
    public static void setAccessRatingsFilter(boolean accessRatingsFilter) {
        FilterPermissions.accessRatingsFilter = accessRatingsFilter;
    }

    /**
     * Changes the boolean value of accessSalesFilter
     * @param accessSalesFilter the current accessibility of sales filter
     */
    public static void setAccessSalesFilter(boolean accessSalesFilter) {
        FilterPermissions.accessSalesFilter = accessSalesFilter;
    }
}
