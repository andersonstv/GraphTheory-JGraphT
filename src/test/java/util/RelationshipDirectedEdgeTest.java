package util;
/*
 * This file was automatically generated by EvoSuite
 * Mon Apr 20 19:18:57 GMT 2020
 */


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Map;

import org.jgrapht.nio.Attribute;
import org.jgrapht.nio.DefaultAttribute;
import org.junit.jupiter.api.Test;
import util.RelationshipDirectedEdge;

public class RelationshipDirectedEdgeTest {

  @Test 
  //(timeout = 4000)
  public void test00()  throws Throwable  {
      RelationshipDirectedEdge relationshipDirectedEdge0 = new RelationshipDirectedEdge();
      relationshipDirectedEdge0.setAttrs((Map<String, Attribute>) null);
      Map<String, Attribute> map0 = relationshipDirectedEdge0.getAtts();
      assertNull(map0);
  }

  @ Test //(timeout = 4000)
  public void test01()  throws Throwable  {
      RelationshipDirectedEdge relationshipDirectedEdge0 = new RelationshipDirectedEdge("2v4;");
      Map<String, Attribute> map0 = relationshipDirectedEdge0.getAtts();
      assertFalse(map0.isEmpty());
  }

  @ Test //(timeout = 4000)
  public void test02()  throws Throwable  {
      RelationshipDirectedEdge relationshipDirectedEdge0 = new RelationshipDirectedEdge((String) null);
      Double double0 = new Double(0.0);
      Attribute attribute0 = DefaultAttribute.createAttribute(double0);
      relationshipDirectedEdge0.setAtt((String) null, attribute0);
      Object object0 = relationshipDirectedEdge0.getAtt((String) null);
      assertSame(object0, attribute0);
  }

  @Test//(timeout = 4000)
  public void test03()  throws Throwable  {
      RelationshipDirectedEdge relationshipDirectedEdge0 = new RelationshipDirectedEdge("(null:null)");
      RelationshipDirectedEdge relationshipDirectedEdge1 = new RelationshipDirectedEdge();
      boolean boolean0 = relationshipDirectedEdge0.equals(relationshipDirectedEdge1);
      assertFalse(boolean0);
  }

  @Test//(timeout = 4000)
  public void test04()  throws Throwable  {
      RelationshipDirectedEdge relationshipDirectedEdge0 = new RelationshipDirectedEdge();
      relationshipDirectedEdge0.setAttrs((Map<String, Attribute>) null);
      // Undeclared exception!
      try { 
        relationshipDirectedEdge0.toString();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         //verifyException("util.RelationshipDirectedEdge", e);
      }
  }

  @Test//(timeout = 4000)
  public void test05()  throws Throwable  {
      RelationshipDirectedEdge relationshipDirectedEdge0 = new RelationshipDirectedEdge();
      Long long0 = new Long((-1L));
      Attribute attribute0 = DefaultAttribute.createAttribute(long0);
      relationshipDirectedEdge0.setAttrs((Map<String, Attribute>) null);
      // Undeclared exception!
      try { 
        relationshipDirectedEdge0.setAtt("(null:null)", attribute0);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         //verifyException("util.RelationshipDirectedEdge", e);
      }
  }

  @Test//(timeout = 4000)
  public void test06()  throws Throwable  {
      RelationshipDirectedEdge relationshipDirectedEdge0 = new RelationshipDirectedEdge((String) null);
      // Undeclared exception!
      try { 
        relationshipDirectedEdge0.getNeighbour((Object) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         //verifyException("util.RelationshipDirectedEdge", e);
      }
  }

  @Test//(timeout = 4000)
  public void test07()  throws Throwable  {
      RelationshipDirectedEdge relationshipDirectedEdge0 = new RelationshipDirectedEdge();
      relationshipDirectedEdge0.setAttrs((Map<String, Attribute>) null);
      // Undeclared exception!
      try { 
        relationshipDirectedEdge0.getLabel();
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         //verifyException("util.RelationshipDirectedEdge", e);
      }
  }

  @Test//(timeout = 4000)
  public void test08()  throws Throwable  {
      RelationshipDirectedEdge relationshipDirectedEdge0 = new RelationshipDirectedEdge();
      // Undeclared exception!
      try { 
        relationshipDirectedEdge0.equals((RelationshipDirectedEdge) null);
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         //verifyException("util.RelationshipDirectedEdge", e);
      }
  }

  @Test//(timeout = 4000)
  public void test09()  throws Throwable  {
      RelationshipDirectedEdge relationshipDirectedEdge0 = new RelationshipDirectedEdge();
      String string0 = relationshipDirectedEdge0.getLabel();
      assertEquals("(null:null)", string0);
  }

  @Test//(timeout = 4000)
  public void test10()  throws Throwable  {
      RelationshipDirectedEdge relationshipDirectedEdge0 = new RelationshipDirectedEdge((String) null);
      String string0 = relationshipDirectedEdge0.getLabel();
      assertNotNull(string0);
  }

  @Test//(timeout = 4000)
  public void test11()  throws Throwable  {
      RelationshipDirectedEdge relationshipDirectedEdge0 = new RelationshipDirectedEdge();
      String string0 = relationshipDirectedEdge0.toString();
      assertEquals("(null:null)", string0);
  }

  @Test//(timeout = 4000)
  public void test12()  throws Throwable  {
      RelationshipDirectedEdge relationshipDirectedEdge0 = new RelationshipDirectedEdge((String) null);
      String string0 = relationshipDirectedEdge0.toString();
      assertNotNull(string0);
  }

  @Test//(timeout = 4000)
  public void test13()  throws Throwable  {
      RelationshipDirectedEdge relationshipDirectedEdge0 = new RelationshipDirectedEdge();
      relationshipDirectedEdge0.hashCode();
  }

  @Test//(timeout = 4000)
  public void test14()  throws Throwable  {
      RelationshipDirectedEdge relationshipDirectedEdge0 = new RelationshipDirectedEdge();
      Object object0 = relationshipDirectedEdge0.getNeighbour("(null:null)");
      assertNull(object0);
  }

  @Test//(timeout = 4000)
  public void test15()  throws Throwable  {
      RelationshipDirectedEdge relationshipDirectedEdge0 = new RelationshipDirectedEdge();
      boolean boolean0 = relationshipDirectedEdge0.equals(relationshipDirectedEdge0);
      assertTrue(boolean0);
  }

  @Test//(timeout = 4000)
  public void test16()  throws Throwable  {
      RelationshipDirectedEdge relationshipDirectedEdge0 = new RelationshipDirectedEdge();
      relationshipDirectedEdge0.setAttrs((Map<String, Attribute>) null);
      // Undeclared exception!
      try { 
        relationshipDirectedEdge0.getAtt("boolean");
        fail("Expecting exception: NullPointerException");
      
      } catch(NullPointerException e) {
         //
         // no message in exception (getMessage() returned null)
         //
         //verifyException("util.RelationshipDirectedEdge", e);
      }
  }

  @Test//(timeout = 4000)
  public void test17()  throws Throwable  {
      RelationshipDirectedEdge relationshipDirectedEdge0 = new RelationshipDirectedEdge();
      Map<String, Attribute> map0 = relationshipDirectedEdge0.getAtts();
      assertEquals(0, map0.size());
  }

  @Test//(timeout = 4000)
  public void test18()  throws Throwable  {
      RelationshipDirectedEdge relationshipDirectedEdge0 = new RelationshipDirectedEdge();
      Object object0 = relationshipDirectedEdge0.getVTarget();
      assertNull(object0);
  }

  @Test//(timeout = 4000)
  public void test19()  throws Throwable  {
      RelationshipDirectedEdge relationshipDirectedEdge0 = new RelationshipDirectedEdge();
      Object object0 = relationshipDirectedEdge0.getVSource();
      assertNull(object0);
  }

  @Test//(timeout = 4000)
  public void test20()  throws Throwable  {
      RelationshipDirectedEdge relationshipDirectedEdge0 = new RelationshipDirectedEdge("(null:null)");
      Object object0 = relationshipDirectedEdge0.getAtt("(null:null)");
      assertNull(object0);
  }
}

