Запуск локально (local) на эмуляторе:
```bash 
gradle clean local_test -DdeviceHost=local
```

Запуск удаленно (remote) на Browserstack:
```bash 
gradle clean remote_test -DdeviceHost=remote
```