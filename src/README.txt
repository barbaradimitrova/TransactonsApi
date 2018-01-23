N26 Challenge

The application accepts json Transactions, stored in a LinkedList.

With every insertion the LinkedList is cleaned (O(n)).
A get request iterated through the LinkedList in Memory and gives back the TrsansactionStatistics.
A LinkedList was chosen because of O(n), compared to O(n2) for ArrayList.
It also cleans the LinkedList for faster future computation.
The statistics of the transactions are not retrieved in O(1).
