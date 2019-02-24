Test maven (transitive) dynamic dependencies
============================================

This project declares a dependency to

```
org.igniterealtime.smack:smack-tcp:4.3.2
```

which itself declares, over `smack-core` a dependency to

```
org.jxmpp:jxmpp-core:[0.6, 0.7)
```

However, different build systems resolve this ranged dynamic
dependency differently.


It failes with `mvn` (Maven)

```bash
$ mvn exec:java
…
Smack version: 4.3.2 (4.3.2-4.3 2019-02-22)
jxmpp version: 0.7.0-alpha5
ERROR: jxmpp version does not start with '0.6' as expected. :(
```

because an errornous version of jxmpp (0.7.0-alpha5 at the time of
writing) is pulled in.

And is successful with `gradle` (Gradle)

```bash
$ gradle run
…
Smack version: 4.3.2 (4.3.2-4.3 2019-02-22)
jxmpp version: 0.6.3
```
