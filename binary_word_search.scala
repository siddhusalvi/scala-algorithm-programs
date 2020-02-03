/*
Filename: binary_word_search
Created: Siddhesh Salvi
Change history:1.2.2020 / Siddhesh Salvi

Problem Statement:
2. Binary Search the Word from Word List
a. Desc -> Read in a list of words from File. Then prompt the user to enter a word to
search the list. The program reports if the search word is found in the list.
b. I/P -> read in the list words comma separated from a File and then enter the word
to be searched
c. Logic -> Use Arrays to sort the word list and then do the binary search
d. O/P -> Print the result if the word is found or not
 */
import scala.io.Source
import scala.util.Sorting.quickSort
object binary_word_search {
  def main(args: Array[String]): Unit = {
    var flag = true
    while(flag){
      try{
        var file = "/home/admin1/IdeaProjects/scala_algorithm/src/main/scala/words.csv"

        var data = Source.fromFile(file)
        var sentence : String = ""
        for(line <- data.getLines){
          sentence += line
        }
        var st =sentence.replace(","," ")
        var words = st.split(" ")

        print("Enter word to find : ")
        var word = scala.io.StdIn.readLine()
        quickSort(words)
        print("\n words are "+words.mkString(""))
        wordSearch(words, word, 0, words.length)
        flag = false
      }
      catch{
        case _=>print("Something went wrong Error occured.\n")
      }
    }
  }
  //Function to find word binary search techniques
  def wordSearch(data:Array[String],word:String,min :Int ,max:Int)
  : Unit ={
    if(min > max){
      print("\n Word not found in wordlist.")
    }else{
      var mid = min + (max - min ) / 2
      var result = data(mid).compareTo(word)
      if(result > 0){
        wordSearch(data, word, min , mid-1)
      }else if(result < 0){
        wordSearch(data, word, mid + 1, max)
      }else{
        print("\nWord found in wordlist")
      }
    }
  }
}
