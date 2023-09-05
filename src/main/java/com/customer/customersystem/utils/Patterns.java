package com.customer.customersystem.utils;

public class Patterns {

    public static final String CPF_VALIDATOR_PATTERN = "^(?!000\\.|00\\.0|0\\.00)[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}\\-?[0-9]{2}$";

    public static final String CNPJ_VALIDATOR_PATTERN = "^(?!00\\.000\\.000\\/0000\\-00|11\\.111\\.111\\/1111\\-11|22\\.222\\.222\\/2222\\-22|33\\.333\\.333\\/3333\\-33|44\\.444\\.444\\/4444\\-44|55\\.555\\.555\\/5555\\-55|66\\.666\\.666\\/6666\\-66|77\\.777\\.777\\/7777\\-77|88\\.888\\.888\\/8888\\-88|99\\.999\\.999\\/9999\\-99)[0-9]{2}\\.?[0-9]{3}\\.?[0-9]{3}\\/?[0-9]{4}\\-?[0-9]{2}$";

    public static final String CPF_MASK_PATTERN = "^([0-9]{3})([0-9]{3})([0-9]{3})([0-9]{2})$";

    public static final String CNPJ_MASK_PATTERN = "^([0-9]{2})([0-9]{3})([0-9]{3})([0-9]{4})([0-9]{2})$";

    public static final String CPF_PATTERN = "$1.$2.$3-$4";

    public static final String CNPJ_PATTERN = "$1.$2.$3/$4-$5";

}
