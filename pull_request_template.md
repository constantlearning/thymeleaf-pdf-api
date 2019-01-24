# Pull Request Template

## Description

Please include a summary of what should be implemented or which problem has been corrected. Please also include relevant motivation and context.

JIRA # [JIR-404 - Something](url)

## Solution

Please include a summary of the change and what has been implemented. Please also include relevant motivation and context. List all the dependencies required for this change.

## Results

Please describe the tests that you ran to verify your changes. Please also note any relevant details for your test configuration.

### Request:
> Url: **POST** {{url}}/hello/{{hello-code}}

Payload:
```json
{
    "key" : "value"
}
```
### Response:
> Status: **200 OK**

Payload:
```json
{
    "key" :  "value"
}
```
### Screenshots:

## Checklist:

- [ ] Maven Clean Install
- [ ] Unit Tests
- [ ] Documentation
- [ ] Postman Collection
