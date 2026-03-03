Data Structures & Algorithms – Assignment 2 (Java)

A Java implementation of an n × n board game with a computer AI that evaluates moves using a custom-built hash table.
Focuses on hash table design, collision handling, and game-state evaluation.

⸻

Features
	•	n × n board stored using char[][]
	•	Win detection (row, column, diagonal)
	•	Draw detection with movement constraints
	•	Game-state evaluation scoring:
	•	3 → Computer win
	•	2 → Draw
	•	1 → Undecided
	•	0 → Human win
	•	Custom hash table implementation (separate chaining)
	•	Collision detection for hash performance analysis
	•	Memoization of board layouts to prevent recomputation

⸻

Core Components
	•	Layout – Encodes board states as strings with associated scores
	•	HashDictionary – Custom hash table (no use of hashCode() or HashMap)
	•	Board – Game logic, evaluation, and state management
	•	DictionaryException – Custom exception handling

⸻

Tech Stack
	•	Java
	•	Object-Oriented Design
	•	Custom Hash Table Implementation
