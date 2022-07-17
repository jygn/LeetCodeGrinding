// Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, otherwise, return false.
// Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at s[i] and s[j].
// For example, swapping at indices 0 and 2 in "abcd" results in "cbad".
// todo ... https://leetcode.com/problems/buddy-strings/ 
pub fn buddy_strings(s: String, goal: String) -> bool {
  if s.len() != goal.len() {
    return false;
  }

  let mut i = 1;
  let mut s_bytes = s.as_bytes();

  for b in s_bytes {

    println!("{:?}", s_bytes);

    let old_b = b;
    *b = s_bytes[i]; 

    
    println!("{:?}", s_bytes);
    if s_bytes.eq(goal.as_bytes()) {
      return true;
    }

    b = old_b;

    i += 1;
    if i > s_bytes.len() - 1 {
      break;
    }
  }

  return false;
}

fn main() {
   println!("{}", buddy_strings("ab".to_string(), "ba".to_string()));
}