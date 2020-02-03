/*
Filename: anagram
Created: Siddhesh Salvi
Change history:3.2.2020 / Siddhesh Salvi

6. An Anagram Detection Example
a. Desc -> One string is an anagram of another if the second is simply a
rearrangement of the first. For example, 'heart' and 'earth' are anagrams...
b. I/P -> Take 2 Strings as Input such abcd and dcba and Check for Anagrams
c. O/P -> The Two Strings are Anagram or not....
*/


import scala.util.Sorting.quickSort
object anagram {
  def main(args: Array[String]): Unit = {
    var flag = true
    while(flag){
      try{
        print("Enter the first word : ")
        var word1 = scala.io.StdIn.readLine()
        print("Enter the second word : ")
        var word2 = scala.io.StdIn.readLine()
        if(areAnagram(word1, word2)){
          print("\n "+word1+" and "+word2+" are Anagram ")
        }else{
          print("\n "+word1+" and "+word2+" are not Anagram ")
        }
        flag = false
      }
      catch{
        case _=>print("\nSomething went wrong Error occurred.\n")
      }
    }
  }
  //functon to check anagram
  def areAnagram(word1: String, word2: String):Boolean ={
    if(word1.length() != word2.length()){
      false
    }else{
      var dta1 = word1.toCharArray()
      quickSort(dta1)
      var dta2 = word2.toCharArray()
      quickSort(dta2)
      for(i <- 0 until dta1.length){
        if(dta1(i).asDigit != dta2(i).asDigit){
          return false
        }
      }
      true
    }
  }
}