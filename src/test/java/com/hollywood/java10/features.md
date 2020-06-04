# Java 10

* Local var type inference (var keyword)
* Bunch of internal changes

Limited use but using best practise as described here can reduce clutter in certain cases and improve readability of code.

http://openjdk.java.net/projects/amber/LVTIstyle.html

1. Choose good variable names
2. Limit scope of local vars
3. var is a good choice when initializer provides detail of type
4. Use var to break up chained or nested expressions with local variables.
5. Don't worry too much about "programming to the interface" with local variables.
6. Take care when using var with diamond or generic methods.
eg 
// DANGEROUS: infers as PriorityQueue<Object>
var itemQueue = new PriorityQueue<>();
7. Take care when using var with literals.
// ORIGINAL
boolean ready = true;
char ch = '\ufffd';
long sum = 0L;
String label = "wombat";

// GOOD
var ready = true;
var ch    = '\ufffd';
var sum   = 0L;
var label = "wombat";

// ORIGINAL
byte flags = 0;
short mask = 0x7fff;
long base = 17;

// DANGEROUS: all infer as int
var flags = 0;
var mask = 0x7fff;
var base = 17;
