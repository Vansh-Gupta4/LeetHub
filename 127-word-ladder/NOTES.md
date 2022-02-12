https://leetcode.com/problems/word-ladder/discuss/1764371/A-very-highly-detailed-EXPLANATION
​
So, all this problem is asking us to do, is find a shortest path from our start word to end word using only word inside our list. Now any time you think, find the shortest sequence you should immediately think, alright i need to use some shortest path algorithm like Breadth-First-Search.
​
Let's take an example:-
​
start = be
end = ko
words = ["ce", "mo", "ko", "me", "co"]
So, using this word list we have 4 different path's that we can take to get from our start to end word.
​
So, we can go from "be" -- "ce" -- "co" -- "ko"
There are other's path as well to go from start word to end word, however we only consider the shortest path, the one that has least amount of word in the sequence and in that case that would be:
​
image
​
So, in a typicall Breadth-First-Search we utilize the queue and it's going to store each string that in our sequence & then we also going to have integer value called changes which will be eventually return from our function, which will keep track how many changes do we have in the sequence.
​
So, we intialize our queue that have starting word inside of it i.e. "be", then our changes variable is going to start at 1, this is because at minimum we going to have starting word in our minimum. And finally we have a set which will keep track's of node that have been visited, in this case we just keeping track of string that we have already added inside our queue.
​
queue = ["be"  ]
changes = 1
set = ["be"  ]
So, to start of our bfs, we take "be" off from our queue & we can only change one character at a time. So, first we gonna check by changing the character b, if we can form another word inside our word list.
​
So, we try ae, which is not in our word list. Then, be is already in our set, so we can't use that. Now we try ce and we have that word inside our word list. With that means add ce in our queue.
​
Then we check de, fe and so on............ until we get to me which is inside our word list, so we add me inside our word list as well.