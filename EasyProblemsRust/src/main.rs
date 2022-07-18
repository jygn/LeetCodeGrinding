use std::{cmp::max, collections::{HashSet}};

// Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, otherwise, return false.
// Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].
// For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
// todo ... https://leetcode.com/problems/buddy-strings/ 
pub fn buddy_strings(s: String, goal: String) -> bool {
    if s.len() != goal.len() {
        return false
    }
    let s_cln = s.clone();
    let s_str = s_cln.as_str();

    for i in 0..s.len()-1 {
        for j in 1..s.len() {
            let s = swap(s_str, i, j);
            println!("s: {}", &s);
            println!("g: {}", &goal);
            if s.eq(&goal) {
                return true
            } 
        }
    }
    false
}

fn swap(s: &str, from_idx: usize, to_idx: usize) -> String {
    let mut chars: Vec<_> = s.chars().collect();
    chars.swap(from_idx, to_idx);
    chars.into_iter().collect()
}

// Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
pub fn maximum_product(nums: Vec<i32>) -> i32 {
    let mut max1:Option<i32> = None;
    let mut max2 = -1000; 
    let mut max3 = -1000; 
    let mut min1:Option<i32> = None;
    let mut min2 = 1000; 

    for n in nums {
        match max1 {
            Some(val) =>  { 
                if val < n { 
                    max3 = max2;
                    max2 = max1.unwrap();
                    max1 = Some(n)
                } else if max2 < n {
                    max3 = max2;
                    max2 = n 
                } else if max3 < n {
                    max3 = n
                }
            } 
            None => { 
                max1 = Some(n); 
            }
        }
        match min1 {
            Some(val) => {
                if val > n {
                    min2 = min1.unwrap();
                    min1 = Some(n);
                } else if min2 > n {
                    min2 = n;
                }
            },
            None => { 
                min1 = Some(n); 
            }
        }
    }
    max(max3*max2*max1.unwrap(), 
    max1.unwrap()*min2*min1.unwrap())
}
  
// There is a malfunctioning keyboard where some letter keys do not work. All other keys on the keyboard work properly.
// Given a string text of words separated by a single space (no leading or trailing spaces) 
// and a string brokenLetters of all distinct letter keys that are broken, 
// return the number of words in text you can fully type using this keyboard.
pub fn can_be_typed_words(text: String, broken_letters: String) -> i32 {
    let mut brkn_set = HashSet::new();
    for c in broken_letters.chars() {
        brkn_set.insert(c);
    }
    let mut res = 0;
    let mut brkn_w = false;
    for c in text.chars() {
        if c == ' ' {
            if !brkn_w {
                res += 1
            }
            brkn_w = false;
        }
        match brkn_set.get(&c) {
            Some(val) => {
                if c == *val {
                    brkn_w = true
                }
            }, None => {}
        }
    }
    if !brkn_w {
        res+=1
    } 
    res
}

// A shop is selling candies at a discount. For every two candies sold, the shop gives a third candy for free.
// The customer can choose any candy to take away for free as long as the cost of the chosen candy is 
// less than or equal to the minimum cost of the two candies bought.
// For example, if there are 4 candies with costs 1, 2, 3, and 4, and the customer buys candies with costs 2 and 3, 
// they can take the candy with cost 1 for free, but not the candy with cost 4.
// Given a 0-indexed integer array cost, where cost[i] denotes the cost of the ith candy, return the minimum cost of buying all the candies.
pub fn minimum_cost(cost: Vec<i32>) -> i32 {
    let mut sorted_cost = cost;
    sorted_cost.sort_by(|a, b| b.cmp(a));

    let mut candies: u8 = 0;
    let mut min_cost = 0;

    for v in &sorted_cost {
        if candies != 2 {
            min_cost += v;
            candies += 1
        } else { 
            candies = 0
        }
    }
    min_cost
}

fn f_deref() {
    let mut c = 'a';
    println!("c: {}", c);

    let b = &mut c;
    *b = 'r';

    println!("b: {}", b);
    println!("c: {}", c);
}
  
fn main() {
    println!("{}", minimum_cost(vec![6,5,7,9,2,2])); 
}
