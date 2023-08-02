open module ds {
  requires jdk.attach;
  requires java.instrument;
  requires jdk.unsupported;
  requires java.logging;
  requires java.compiler;
  requires java.management;
  requires net.bytebuddy; // required for mockito to work with JPMS.
  requires net.bytebuddy.agent; // required for mockito to work with JPMS.
  requires transitive org.junit.jupiter.api;
  requires transitive org.junit.jupiter.engine;
  requires transitive org.junit.jupiter.params;
  requires transitive org.junit.platform.commons;
  requires transitive org.junit.platform.engine;
  requires transitive org.junit.platform.launcher;
  requires org.mockito;
  requires org.mockito.junit.jupiter;

  exports ds;
}
