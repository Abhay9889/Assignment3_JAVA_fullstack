# Assignment3_JAVA_fullstack

#CustomListFramework/
│
├── MyList.java
├── MyArrayList.java
├── MyLinkedList.java
├── Main.java
└── README.md

 Architecture Design
✔ MyList Interface

Defines the contract that every list implementation must follow.

Methods included:

add(T element)

insert(T element, int index)

get(int index)

delete(int index)


✔ MyArrayList

An array-backed dynamic list.

Features:

Starts with a small capacity

Automatically doubles capacity when full

Maintains insertion order

Supports indexed access

Performs element shifting during insert/delete

Best suited for:

Fast data retrieval

Memory locality

Fewer pointer operations

✔ MyLinkedList

A singly linked list implementation using nodes.

Features:

Dynamic memory allocation

Efficient insertion and deletion

No resizing required

Uses head reference for traversal

Best suited for:

Frequent insertions/deletions

Situations where resizing is costly

⚠️ Exception Handling

The framework properly handles invalid operations using unchecked exceptions.

Scenario	Exception
Access invalid index	IndexOutOfBoundsException
Insert at invalid position	IndexOutOfBoundsException
Delete from empty list	IllegalStateException
Get from empty list	IllegalStateException

This improves program reliability and prevents silent failures.+
##

| Feature       | Array List        | Linked List    |
| ------------- | ----------------- | -------------- |
| Memory        | Contiguous        | Non-contiguous |
| Access Speed  | Fast (O(1))       | Slower (O(n))  |
| Insert/Delete | Costly (shifting) | Efficient      |
| Resizing      | Required          | Not required   |


size()

isEmpty()
