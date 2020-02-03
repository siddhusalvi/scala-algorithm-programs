/*
Filename: string_permutation
Created: Siddhesh Salvi
Change history:3.2.2020 / Siddhesh Salvi

3. Insertion Sort
a. Desc -> Reads in strings and prints them in sorted order using insertion sort.
b. I/P -> read in the list words
c. Logic -> Use Insertion Sort to sort the words in the String array
d. O/P -> Print the Sorted List
 */

object insertion_sort {
  def main(args: Array[String]): Unit = {
    var flag = true
    while(flag){
      try{
        print("How many words do you want to sort ?  ")
        var num:Int = scala.io.StdIn.readInt()
        var words = new Array[String](num)
        for(i <- 0 until num){
          print("\nEnter word at index "+i+" : ")
          words(i) = scala.io.StdIn.readLine()
          }
        print("\nEntered words are : "+words.mkString(" "))
        sort_insertion(words)
        flag = false
        }
      catch{
        case _=>print("Something wen wrong Error occured.")
      }
      }
    }
  // Function to sort words by insertion sort 
  def sort_insertion(words: Array[String]):Unit ={
    for(i <- 1 until words.length){
      for(j <- i until 0 by -1){
        if(words(j).compareTo(words(j-1)) < 0){
          var temp = words(j-1)
          words(j-1) = words(j)
          words(j) = temp
        }
      }
    }
    print("\nSorted words are : "+words.mkString(" "))
  }
  }
