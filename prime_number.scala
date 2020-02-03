/*
Filename: prime_number
Created: Siddhesh Salvi
Change history:3.2.2020 / Siddhesh Salvi
 
7. Take a range of 0 - 1000 Numbers and find the Prime numbers in that range.
*/

import java.lang.Math.sqrt
object prime_number {
  def main(args: Array[String]): Unit = {
    var flag = true
    while(flag){
      try{
        print("Enter starting point of range : ")
        var start = scala.io.StdIn.readInt()

        print("Enter ending point of range : ")
        var end = scala.io.StdIn.readInt()

        if(start < end){
          prime_range(start,end)
        }else{
          print("Please enter valid input")
        }
        flag = false
      }
      catch{
        case _=>print("Something went wrong Error occurred.\n")
      }
    }
  }
  def prime_range(min: Int, max: Int): Unit ={
    print("Prime numbers between "+min+" and "+max+" : ")
    for(i <- min to max){
      if(isPrime(i)){
        print(i+" ")
      }
    }
  }
  def isPrime(num: Int):Boolean ={
    if(num < 2){
      false
    }else if(num < 4){
      true
    }else{
      for(i <- 2 to sqrt(num).toInt){
        if(num % i == 0){
          return false
        }
      }
      true
    }
  }
}