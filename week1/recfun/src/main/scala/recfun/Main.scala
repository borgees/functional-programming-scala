package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1: Pascal’s Triangle
   */
    def pascal(c: BigInt, r: BigInt): BigInt = {
      if(c == 0 || c == r) 1
      else pascal(c, r - 1) + pascal(c - 1, r - 1)
    }
  
  /**
   * Exercise 2: Parentheses Balancing (http://stackoverflow.com/a/13029280/6872042)
   */
    def balance(chars: List[Char]): Boolean = {
      def balanced(chars: List[Char], open: Int): Boolean = 
        if (chars.isEmpty) open == 0
        else if (chars.head == '(') balanced(chars.tail, open + 1)
        else if (chars.head == ')') open > 0 && balanced(chars.tail, open - 1)
        else balanced(chars.tail,open)
      balanced(chars,0)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      money match {
      case 0  => 1
      case x if x < 0 => 0
      case x if x>=1 && coins.isEmpty => 0
      case _ => countChange(money, coins.tail) + countChange(money - coins.head, coins)
      }
    }
  }
