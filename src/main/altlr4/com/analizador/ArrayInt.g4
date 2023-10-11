
grammar ArrayInt;

/// gramatica
init: '{' value (',' value)* '}';

value: init
    | INT
    ;

// lexer
INT: [0-9]+;
WS: [ \t\r\n]+ -> skip;
