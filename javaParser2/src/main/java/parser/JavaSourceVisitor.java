package parser;

import com.sun.source.tree.ExpressionTree;
import com.sun.source.tree.MethodTree;
import com.sun.source.tree.VariableTree;
import com.sun.source.util.TreeScanner;

import java.util.ArrayList;
import java.util.List;
public class JavaSourceVisitor extends TreeScanner {

    private List arg0 = new ArrayList();
    public List getMethodList() {
        if(arg0 ==null)
        {
            arg0 = new ArrayList();
        }
        return arg0;
    }
    public void setMethodList(List methodList) {
        this.arg0 = methodList;
    }
    @Override
    public Object visitMethod(MethodTree mt, Object obj) {

        if(mt!=null)
        {
            JavaMethodDTO javaMethodDto = new JavaMethodDTO();

            System.out.println();
//            String modifier = StringTool.getObjectStringValue(mt.getModifiers());
            String modifier = mt.getModifiers().toString();
            System.out.println("mt.getModifiers() : " + modifier);

//            String returnType = StringTool.getObjectStringValue(mt.getReturnType());
            String returnType = mt.getReturnType().toString();
            System.out.println("mt.getReturnType() : " + returnType);

//            String methodName = StringTool.getObjectStringValue(mt.getName());
            String methodName = mt.getName().toString();
            System.out.println("mt.getName() : " + methodName);

            List paramStrList = new ArrayList();

            List<? extends VariableTree> paramList = mt.getParameters();
            if(paramList!=null)
            {
                for(VariableTree vt : paramList)
                {
//                    String paramStr = StringTool.getObjectStringValue(vt);
                    String paramStr = vt.toString();
                    System.out.println("param : " + paramStr);
                    paramStrList.add(paramStr);
                }
            }

            //System.out.println("mt.getDefaultValue() : " + StringTool.getObjectStringValue(mt.getDefaultValue()));

            //System.out.println("mt.getKind() : " + StringTool.getObjectStringValue(mt.getKind()));

            List throwsStrList = new ArrayList();

            List<? extends ExpressionTree> throwsList = mt.getThrows();
            if(throwsList!=null)
            {
                for(ExpressionTree et : throwsList)
                {
//                    String throwsStr = StringTool.getObjectStringValue(et);
                    String throwsStr = et.toString();
                    System.out.println("throws : " + throwsStr);
                    throwsStrList.add(throwsStr);
                }
            }

//            String methodBody = StringTool.getObjectStringValue(mt.getBody());
            String methodBody = mt.getBody().toString();


            System.out.println("mt.getBody() : " + methodBody);

            javaMethodDto.setMethodModifier(modifier);
            javaMethodDto.setMethodReturnType(returnType);
            javaMethodDto.setMethodName(methodName);
            javaMethodDto.setMethodParamList(paramStrList);
            javaMethodDto.setMethodThrowsList(throwsStrList);
            javaMethodDto.setMethodBody(methodBody);

            this.arg0.add(javaMethodDto);
        }

        if(obj!=null)
        {
            System.out.println(obj.toString());
        }

        return super.visitMethod(mt, obj);
    }
    @Override
    public Object visitVariable(VariableTree arg0, Object arg1) {
        if(this.arg0 !=null)
        {
            JavaMethodDTO javaMethodDto = new JavaMethodDTO();

            System.out.println();

//            String modifier = StringTool.getObjectStringValue(mt.getModifiers());
            String modifier = arg0.getModifiers().toString();
            System.out.println("mt.getModifiers() : " + modifier);

//            String returnType = StringTool.getObjectStringValue(mt.getReturnType());
            String returnType = arg0.getType().toString();
            System.out.println("mt.getReturnType() : " + returnType);

//            String methodName = StringTool.getObjectStringValue(mt.getName());
            String methodName = arg0.getName().toString();
            System.out.println("mt.getName() : " + methodName);

//            List paramStrList = new ArrayList();

//            List<? extends VariableTree> paramList = arg0.getParameters();
//            if(paramList!=null)
//            {
//                for(VariableTree vt : paramList)
//                {
////                    String paramStr = StringTool.getObjectStringValue(vt);
//                    String paramStr = vt.toString();
//                    System.out.println("param : " + paramStr);
//                    paramStrList.add(paramStr);
//                }
//            }

            //System.out.println("mt.getDefaultValue() : " + StringTool.getObjectStringValue(mt.getDefaultValue()));

            //System.out.println("mt.getKind() : " + StringTool.getObjectStringValue(mt.getKind()));

//            List throwsStrList = new ArrayList();

//            List<? extends ExpressionTree> throwsList = arg0.getThrows();
//            if(throwsList!=null)
//            {
//                for(ExpressionTree et : throwsList)
//                {
////                    String throwsStr = StringTool.getObjectStringValue(et);
//                    String throwsStr = et.toString();
//                    System.out.println("throws : " + throwsStr);
//                    throwsStrList.add(throwsStr);
//                }
//            }

//            String methodBody = StringTool.getObjectStringValue(mt.getBody());
//            String methodBody = arg0.getBody().toString();
//
//            System.out.println("mt.getBody() : " + methodBody);
//
//            javaMethodDto.setMethodModifier(modifier);
//            javaMethodDto.setMethodReturnType(returnType);
//            javaMethodDto.setMethodName(methodName);
//            javaMethodDto.setMethodParamList(paramStrList);
//            javaMethodDto.setMethodThrowsList(throwsStrList);
//            javaMethodDto.setMethodBody(methodBody);

            this.arg0.add(javaMethodDto);
        }

        if(arg1!=null)
        {
            System.out.println(arg1.toString());
        }

        return super.visitVariable(arg0, arg1);
    }


}
