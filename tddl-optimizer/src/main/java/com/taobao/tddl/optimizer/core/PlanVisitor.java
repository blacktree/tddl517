package com.taobao.tddl.optimizer.core;

import com.taobao.tddl.optimizer.core.expression.*;
import com.taobao.tddl.optimizer.core.expression.bean.NullValue;
import com.taobao.tddl.optimizer.core.plan.dml.IDelete;
import com.taobao.tddl.optimizer.core.plan.dml.IInsert;
import com.taobao.tddl.optimizer.core.plan.dml.IReplace;
import com.taobao.tddl.optimizer.core.plan.dml.IUpdate;
import com.taobao.tddl.optimizer.core.plan.query.IJoin;
import com.taobao.tddl.optimizer.core.plan.query.IQuery;

import java.util.List;

public interface PlanVisitor {

    public abstract void visit(IColumn column);

    public abstract void visit(IFilter filter);

    public abstract void visit(IFunction func);

    public abstract void visit(IJoin join);

    public abstract void visit(IOrderBy orderBy);

    public abstract void visit(IQuery query);

    public abstract void visit(NullValue nullValue);

    public abstract void visit(List cl);

    public abstract void visit(Object s);

    public abstract void visit(IReplace put);

    public abstract void visit(IInsert insert);

    public abstract void visit(IUpdate update);

    public abstract void visit(IDelete delete);

    public abstract void visit(IBindVal bindVal);
}
