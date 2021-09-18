import java.util.ArrayList;
import java.util.Arrays;

/**
 * A WordGram represents a sequence of strings
 * just as a String represents a sequence of characters
 * 
 * @author YOUR NAME HERE
 *
 */
public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram by creating instance variable myWords and copying
	 * size strings from source starting at index start
	 * @param source is array of strings from which copying occurs
	 * @param start starting index in source for strings to be copied
	 * @param size the number of strings copied
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		// TODO: initialize all instance variables
		int myWords_index = 0;
		for(int i = 0; i < source.length; i++){
			if(i >= start && myWords_index < (size - 1)){
				myWords[myWords_index] = source[i];
				myWords_index += 1;
			}
		}
		//myToString = null;
		myToString = myWords.toString();
		myHash = 0;

	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Complete this comment
	 * @return
	 */
	public int length(){
		// TODO: change this
		//return 0;
		return this.myWords.length;

	}


	/**
	 * Complete appropriate comment here
	 * @param other
	 * @return
	 */
	@Override
	public boolean equals(Object other) {
		// TODO: Complete this method
		if (! (other instanceof WordGram) || other == null){
			return false;
		} else {
			WordGram wg = (WordGram) other;

			// if the arrays are of different lengths they are not equal; return false
			if(this.myWords.length != wg.myWords.length){
				return false;
			}

			// if the arrays are of the same length check the equivalency of each parallel element
			boolean equiv = true;
			for(int i = 0; i < this.myWords.length; i++){
				if(this.myWords[i] != wg.myWords[i]){
					equiv = false;
				}
			}
			return equiv;
		}

		//return true;
	}

	@Override
	public int hashCode(){
		// TODO: complete this method: assign to myHash as needed
		//return myHash;
		// note: hashcodes must be ints
		if(this.myHash == 0){
			this.myHash = this.toString().hashCode();
		}
		return this.myHash;
	}
	

	/**
	 * Create and complete this comment
	 * @param last is last String of returned WordGram
	 * @return
	 */
	public WordGram shiftAdd(String last) {
		//WordGram wg = new WordGram(myWords,0,myWords.length);
		// TODO: Complete this method

		// create an ArrayList to store and modify word gram words
		ArrayList<String> words = new ArrayList<>();
		words.addAll(Arrays.asList(this.myWords));

		// remove the first element from the ArrayList
		words.remove(0);

		// add the parameter "last" to end of the ArrayList
		words.add(last);

		// convert words ArrayList to array which can be passed to WordGram() constructor
		String[] wordsArray = words.toArray(new String[words.size()]);

		// create a new wordgram object where myWords is wordsArray
		WordGram wg = new WordGram(wordsArray,0,myWords.length);

		return wg;
	}

	@Override
	public String toString(){
		// TODO: Complete this method, assign to myToString as needed
		if(this.myToString != null){
			this.myToString = String.join(" ", this.myWords);
		}
		return this.myToString;
	}
}
