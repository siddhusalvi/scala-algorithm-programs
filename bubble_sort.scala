/*
Filename: b
Created: Siddhesh Salvi
Change history:3.2.2020 / Siddhesh Salvi

4. Bubble Sort
a. Desc -> Reads in integers prints them in sorted order using Bubble Sort
b. I/P -> read in the list ints
c. O/P -> Print the Sorted List
 */
object bubble_sort {
  def main(args: Array[String]): Unit = {
    var flag = true
    while(flag){
      try{
        print("How many numbers do you want to sort ?  ")
        var num = scala.io.StdIn.readInt()
        var numbers = new Array[Int](num)
        for(i <- 0 until num){
          print("Enter data for "+(i+1)+" : ")
          numbers(i) = scala.io.StdIn.readInt()
        }
        print("\nEntered numbers are : "+numbers.mkString(" "))
        print("\nSorted array is : "+sort_bubble(numbers).mkString(" "))

        flag = false
      }
      catch{
        case _=>print("Something went wrong Error occurred.")
      }
    }
  }
  //Function to sort array by bubble sort technique
  def sort_bubble(data: Array[Int]):Array[Int]={
    for(i <- 0 until data.length-1){
      for(j <- 0 until data.length-1-i){
        if(data(j) > data(j+1)){
          var temp = data(j)
          data(j) = data(j+1)
          data(j+1) = temp
        }
      }
    }
    return data
  }
}