package isbnvalidator;

public class ValidateISBN {
    private static final int ISBN_LENGTH=10;

    public boolean checkISBN(String isbn) {
        if(isbn.length()!=ISBN_LENGTH)throw new NumberFormatException("Need 10/13 numbers");

        if(!isbn.matches("[0-9]{10}|[0-9]{9}X")){
            throw new NumberFormatException("Insert Only Numbers");
        }

        int total = 0;
        for (int i = 0; i < ISBN_LENGTH; i++) {
            if(i==(ISBN_LENGTH-1) && isbn.charAt(i)=='X'){
                total+=10;
            }else{
                total += Character.getNumericValue(isbn.charAt(i))  * (10 -i);
            }
        }

        return total % 11 == 0;
    }
}
