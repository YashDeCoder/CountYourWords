# Project Description
I am creating a text parser in Java named CountYourWords.

# Constraints
- Numbers in the document are ignored and are not processed
- Other characters than words should be filtered out of the input, so ## or @ or !! are ignored
- You do not have to take in account strange combinations like: love4u or mail@address.nl,
combinations like these are out of scope for this assignment
- Next to showing the total number of words in the document, the number of occurrences of
each word is also calculated
- The total number of occurrences next to the word must be shown on screen one by one (in
lowercase)
- Counting the occurrences per word is case insensitive (so Matchbox, matchbox, and
MATCHBOX are all the same word)
- When printing the occurrences, the words must be in alphabetical order
- You cannot use a built-in .NET sort routine, so produce on of your own, it does not have to be
the fastest sort-routine as long as it is reliable end reusable.
- The document is a text file that will be read by your console app and has the fixed name:
input.txt

# Goal
- The code must be production code, use everything you would use in production. You are allowed to use third party components if required (except for the sorting)
- All classes can be in one .NET core console application (assembly), as long as you show clear separation
- Everything must be done using testing and TDD
- Use SOLID and object-oriented programming