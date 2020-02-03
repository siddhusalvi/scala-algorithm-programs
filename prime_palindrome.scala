/*
Filename: prime_palindrome
Created: Siddhesh Salvi
Change history:3.2.2020 / Siddhesh Salvi
7. Take a range of 0 - 1000 Numbers and find the Prime numbers in that range.
8. Extend the above program to find the prime numbers that are Anagram and
Palindrome
*/


import java.lang.Math.sqrt
object prime_palindrome {
  def main(args: Array[String]): Unit = {
    var flag = true
    while(flag){
      try{
        print("Enter starting point of range : ")
        val start = scala.io.StdIn.readInt()

        print("Enter ending point of range : ")
        val end = scala.io.StdIn.readInt()

        if(start < end){
          primedrome(start,end)
          flag = false
        }else{
          print("Please enter valid input")
        }
      }
      catch{
        case _=>print("Something went wrong Error occurred.")
      }
    }
  }
  //function to print prime as well palindrome number in given range
  def primedrome(min: Int, max: Int): Unit ={
    print("Prime as well as Palindrome numbers between "+min+" and "+max+" : ")
    for(i <- min to max){
      if(isPalindrome(i.toString.toCharArray()) && isPrime(i)){
        print(i+" ")
      }
    }
  }
  //function to check prime number
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
  //function to check palindrome number
  def isPalindrome(word: Array[Char]): Boolean ={
    var left = 0
    var right = word.length-1
    while(left < right){
      if(word(left).asDigit != word(right).asDigit){
        return false
      }
      left += 1
      right -= 1
    }
    true
  }
}