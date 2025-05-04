package com.wso2.checks;

import com.puppycrawl.tools.checkstyle.api.*;

public class MethodBodyTopPaddingCheck extends AbstractCheck {

    private static final String MSG_KEY = "method.body.top.blank.line";

    @Override
    public int[] getDefaultTokens() {
        return new int[] { TokenTypes.METHOD_DEF };
    }

    @Override
    public void visitToken(DetailAST methodDef) {
        DetailAST slist = methodDef.findFirstToken(TokenTypes.SLIST);
        if (slist == null) {
            return;
        }

        // Line of opening brace `{`
        int braceLine = slist.getLineNo();

        // First code statement inside the method body
        DetailAST firstStatement = slist.getFirstChild();
        while (firstStatement != null && firstStatement.getType() == TokenTypes.LCURLY) {
            firstStatement = firstStatement.getNextSibling();
        }

        if (firstStatement != null) {
            int firstStatementLine = firstStatement.getLineNo();

            if (firstStatementLine <= braceLine || firstStatementLine == braceLine + 1) {
                log(firstStatementLine, firstStatement.getColumnNo(), MSG_KEY);
            }
        }
    }

    @Override
    public int[] getAcceptableTokens() {
        return getDefaultTokens();
    }

    @Override
    public int[] getRequiredTokens() {
        return getDefaultTokens();
    }
}
