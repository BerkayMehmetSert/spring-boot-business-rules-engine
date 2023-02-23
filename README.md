# Business Rules Engine

This is a sample Business Rules Engine that can be used to evaluate a set of rules against a set of facts. 

### Usage

```java
public void foo(String value){
    BusinessRules.run(()->{
        entityRule.rule1(value);
        entityRule.rule2(value);
    });
    
    // ...
}
```

### Error Result

```json
{
  "type": "https://example.com/business-exception",
  "title": "Business Exception",
  "status": 400,
  "detail": "Exception message",
  "instance": "/api/controller",
  "timestamp": "2023-02-23 17:07:39"
}
```

