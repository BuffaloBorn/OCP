package print;

import jdk.internal.org.objectweb.asm.ClassReader;
import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;
import jdk.internal.org.objectweb.asm.tree.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by Vitaly on 06.07.2016.
 */
public class PrintUtils {
    public static void printSectionName(String sectionName) {
        System.out.printf("----------------------------------------------------%s----------------------------------------------------\n", sectionName);
    }

    public static void printDelimiterString() {
        printSectionName("");
    }

    public static void printVariable(Object variable) {

    }

//    public static void main(String[] args) throws IOException {
//        final ClassReader reader = new ClassReader("revel/reflection/test/SomeClass");
//        final ClassNode classNode = new ClassNode();
//        reader.accept(classNode, 0);
//        for(final MethodNode mn : (List<MethodNode>)classNode.methods) {
//            if(mn.name.equalsIgnoreCase("testLocals")) {
//                final InsnList list = new InsnList();
//
//                for(final LocalVariableNode local : (List<LocalVariableNode>)mn.localVariables) {
//                    System.out.println("Local Variable: " + local.name + " : " + local.desc + " : " + local.signature + " : " + local.index);
//                    if(local.desc.contains("String")) {
//                        mn.visitVarInsn(Opcodes.ALOAD, local.index);
//                        final VarInsnNode node = new VarInsnNode(Opcodes.ALOAD, 1);
//
//                        list.add(node);
//                        System.out.println("added local var '" + local.name + "'");
//                    }
//                }
//
//                final MethodInsnNode insertion = new MethodInsnNode(Opcodes.INVOKESTATIC, "revel/reflection/test/Test", "printLocalString", "(Ljava/lang/String;)V");
//                list.add(insertion);
//                mn.instructions.insert(list);
//            }
//        }
//
//        ClassWriter writer = new ClassWriter(0);
//        classNode.accept(writer);
//
//        loadClass(writer.toByteArray(), "revel.reflection.test.SomeClass");
//        SomeClass.testLocals(true);
//    }
//    public static void testLocals(boolean one) {
//        String two = "hello local variables";
//        one = true;
//        int three = 64;
//    }
}
