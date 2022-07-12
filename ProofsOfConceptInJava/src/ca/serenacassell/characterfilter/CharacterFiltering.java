package ca.serenacassell.characterfilter;

import ca.serenacassell.characterfilter.enums.FilterTypeEnum;

import java.lang.String;

public class CharacterFiltering {

    public static void main(String[] args){

        System.out.print("Uno:  ");
        FilterTypeEnum.FIRST_EXCLUDE.getFilter().forEach(filter -> System.out.print(filter + "  "));
        System.out.println("  ");

        System.out.print("Due:     ");
        FilterTypeEnum.SECOND_EXCLUDE.getFilter().forEach(filter -> System.out.print(filter + "  "));
        System.out.println("  ");


    }

}

