/*
Filename: merge_sort
Created: Siddhesh Salvi
Change history:3.2.2020 / Siddhesh Salvi

5. Merge Sort - Write a program to do Merge Sort of list of Strings.
a. Logic -> To Merge Sort an array, we divide it into two halves, sort the two halves
independently, and then merge the results to sort the full array. To sort a[lo, hi),
we use the following recursive strategy:
b. Base case: If the sub-array length is 0 or 1, it is already sorted.
c. Reduction step: Otherwise, compute mid = lo + (hi - lo) / 2, recursively sort the
two sub-arrays a[lo, mid) and a[mid, hi), and merge them to produce a sorted
result.
*/


object merge_sort {
  def main(args: Array[String]): Unit = {
    var flag = true
    while(flag){
      try{
        print("How many words do you want to sort ?  ")
        var num = scala.io.StdIn.readInt()
        var words = new Array[String](num)

        for(i <- 0 until words.length){
          print("\nEnter word for pos "+(i+1)+" : ")
          words(i) = scala.io.StdIn.readLine()
        }
        print("\nEntered words are : "+words.mkString(" "))
        print("\nSorted data is : "+sort_merge(words,0,words.length-1).mkString(" "))

        flag = false
      }
      catch{
        case _=>print("Something went wrong Error occurred.")
      }
    }
  }
  //Function to sort array using merge sort technique
  def sort_merge(words: Array[String], start: Int, end: Int):Array[String] ={
    if(start < end){
      var mid = (end + start)/2
      var arr1 = sort_merge(words, start, mid)
      var arr2 = sort_merge(arr1, mid+1 ,end)
      var arr3 = merge(arr2, start, mid, end)
      //print("\nsort merge : "+wo.mkString(" "))
      arr3
    } else{
      words
    }
  }

  //function to merge arrays
  def merge(words: Array[String], start:Int,mid:Int, end:Int): Array[String] ={
    var left:Int = start
    var right:Int = mid + 1
    var index:Int = 0
    var temp = new Array[String](end-start+1)

    while(left <= mid && right <= end){
      if(words(left).compareTo(words(right)) < 0){
        temp(index) = words(left)
        left += 1
      }else{
        temp(index) = words(right)
        right += 1
      }
      index += 1
    }
    while(left <= mid){
      temp(index) = words(left)
      left += 1
      index += 1
    }
    while(right <= end){
      temp(index) = words(right)
      right += 1
      index += 1
    }
    index = 0
    for(i <-start to end){
      words(i) = temp(index)
      index += 1
    }
    //print("\n merge "+words.mkString(" "))
    words
  }
}