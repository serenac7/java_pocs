package ca.serenacassell.characterfilter.enums;

import java.lang.String;
import java.util.stream.*;
import java.util.*;

public enum FilterTypeEnum {

    FIRST_EXCLUDE(Arrays.asList(".", "?","!")),
    SECOND_EXCLUDE(Arrays.asList("@", "~"));

    private final List<String> filter;

    FilterTypeEnum(List<String> filterList){
        List<String> filterEveryTime = Arrays.asList("%", "*", "$");
        //Stream the supplied list, and the always-filtered into the filter variable.
        this.filter = Stream.concat(filterList.stream(), filterEveryTime.stream()).collect(Collectors.toList());
    }

    public List<String> getFilter(){
        return this.filter;
    }

}

