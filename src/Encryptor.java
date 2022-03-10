public class Encryptor
{
  /** A two-dimensional array of single-character strings, instantiated in the constructor */
  private String[][] letterBlock;

  /** The number of rows of letterBlock, set by the constructor */
  private int numRows;

  /** The number of columns of letterBlock, set by the constructor */
  private int numCols;

  /** Constructor*/
  public Encryptor(int r, int c)
  {
    letterBlock = new String[r][c];
    numRows = r;
    numCols = c;
  }
  
  public String[][] getLetterBlock()
  {
    return letterBlock;
  }
  
  /** Places a string into letterBlock in row-major order.
   *
   *   @param str  the string to be processed
   *
   *   Postcondition:
   *     if str.length() < numRows * numCols, "A" in each unfilled cell
   *     if str.length() > numRows * numCols, trailing characters are ignored
   */
  public void fillBlock(String str)
  {
    int count = 0;
    String test = str;
    for (int r = 0; r < letterBlock.length; r++)
    {
      for (int c = 0; c < letterBlock[0].length; c++)
      {
        letterBlock[r][c] = test.substring(c, c + 1);
      }
      count += letterBlock[0].length;
      test = str.substring(count);
      if (test.length() < numCols)
      {
        int length = test.length();
        for (int x = 0; x < (numCols-length); x++)
        {
          test += "A";
          str += "A";
        }
      }
    }
  }

  /** Extracts encrypted string from letterBlock in column-major order.
   *
   *   Precondition: letterBlock has been filled
   *
   *   @return the encrypted string from letterBlock
   */
  public String encryptBlock()
  {
    String message = "";
    for (int c = 0; c < letterBlock[0].length; c++)
    {
      for (int r = 0; r < letterBlock.length; r++)
      {
        message += letterBlock[r][c];
      }
    }
    return message;
  }

  /** Encrypts a message.
   *
   *  @param message the string to be encrypted
   *
   *  @return the encrypted message; if message is the empty string, returns the empty string
   */
  public String encryptMessage(String message)
  {
    String substring = message;
    String sub = "";
    for (int r = 0; r < letterBlock.length; r++)
    {
      for (int c = 0; c < letterBlock[0].length; c++)
      {
        letterBlock[r][c] = substring.substring(c,c+1);
        fillBlock(substring);
      }
    }
    sub += encryptBlock();
    while (substring.length() > numRows*numCols)
    {
      substring = substring.substring(numCols*numRows);
      for (int r = 0; r < letterBlock.length; r++)
      {
        for (int c = 0; c < letterBlock[0].length; c++)
        {
          letterBlock[r][c] = substring.substring(c,c+1);
          fillBlock(substring);
        }
      }
      sub += encryptBlock();
    }
    return sub;
  }
  
  /**  Decrypts an encrypted message. All filler 'A's that may have been
   *   added during encryption will be removed, so this assumes that the
   *   original message (BEFORE it was encrypted) did NOT end in a capital A!
   *
   *   NOTE! When you are decrypting an encrypted message,
   *         be sure that you have initialized your Encryptor object
   *         with the same row/column used to encrypted the message! (i.e. 
   *         the �encryption key� that is necessary for successful decryption)
   *         This is outlined in the precondition below.
   *
   *   Precondition: the Encryptor object being used for decryption has been
   *                 initialized with the same number of rows and columns
   *                 as was used for the Encryptor object used for encryption. 
   *  
   *   @param encryptedMessage  the encrypted message to decrypt
   *
   *   @return  the decrypted, original message (which had been encrypted)
   *
   *   TIP: You are encouraged to create other helper methods as you see fit
   *        (e.g. a method to decrypt each section of the decrypted message,
   *         similar to how encryptBlock was used)
   */
  public String decryptMessage(String encryptedMessage)
  {
    String substring = encryptedMessage;
    String sub = "";
    int count = 0;
    for (int c = 0; c < letterBlock[0].length; c++)
    {
      for (int r = 0; r < letterBlock.length; r++)
      {
        letterBlock[r][c] = substring.substring(count, count+1);
        count++;
      }
    }
    sub += decryptBlock();
    while (substring.length() > numRows*numCols)
    {
      count = 0;
      substring = substring.substring(numCols*numRows);
      for (int c = 0; c < letterBlock[0].length; c++)
      {
        for (int r = 0; r < letterBlock.length; r++)
        {
          letterBlock[r][c] = substring.substring(count, count+1);
          count++;
        }
      }
      sub += decryptBlock();
    }
    String decrypted = removeBlock(sub);
    return decrypted;
  }

  public String removeBlock(String str)
  {
    for (int i = str.length()-1; i > 0; i--)
    {
      if (str.substring(i-1,i).equals(("A")))
      {
        str = str.substring(0,i-1);
      }
      else
      {
        break;
      }
    }
    return str;
  }
  public String decryptBlock()
  {
    String message = "";
    for (int r = 0; r < letterBlock.length; r++)
    {
      for (int c = 0; c < letterBlock[0].length; c++)
      {
        message += letterBlock[r][c];
      }
    }
    return message;
  }
}