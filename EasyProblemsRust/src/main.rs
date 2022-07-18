use std::cmp::max;

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

  
fn f_deref() {
    let mut c = 'a';

    println!("c: {}", c);

    let b = &mut c;

    *b = 'r';

    println!("b: {}", b);
    println!("c: {}", c);
}


  
fn main() {
    println!("{}", maximum_product(vec![1,2,3])); 
}
