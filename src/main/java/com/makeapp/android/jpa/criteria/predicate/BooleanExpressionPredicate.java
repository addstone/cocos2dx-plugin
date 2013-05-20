/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2009 by Red Hat Inc and/or its affiliates or by
 * third-party contributors as indicated by either @author tags or express
 * copyright attribution statements applied by the authors.  All
 * third-party contributions are distributed under license by Red Hat Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package com.makeapp.android.jpa.criteria.predicate;

import com.makeapp.android.jpa.criteria.CriteriaBuilderImpl;
import com.makeapp.android.jpa.criteria.CriteriaQueryCompiler;
import com.makeapp.android.jpa.criteria.ParameterRegistry;
import com.makeapp.android.jpa.criteria.Renderable;

import javax.persistence.criteria.Expression;
import java.io.Serializable;

/**
 * Defines a {@link javax.persistence.criteria.Predicate} used to wrap an {@link javax.persistence.criteria.Expression Expression&lt;Boolean&gt;}.
 *
 * @author Steve Ebersole
 */
public class BooleanExpressionPredicate
        extends AbstractSimplePredicate
        implements Serializable
{
    private final Expression<Boolean> expression;

    public BooleanExpressionPredicate(CriteriaBuilderImpl criteriaBuilder, Expression<Boolean> expression)
    {
        super(criteriaBuilder);
        this.expression = expression;
    }

    /**
     * Get the boolean expression defining the predicate.
     *
     * @return The underlying boolean expression.
     */
    public Expression<Boolean> getExpression()
    {
        return expression;
    }

    public void registerParameters(ParameterRegistry registry)
    {
        Helper.possibleParameter(expression, registry);
    }

    public String render(CriteriaQueryCompiler.RenderingContext renderingContext)
    {
        return ((Renderable) getExpression()).render(renderingContext);
    }

    public String renderProjection(CriteriaQueryCompiler.RenderingContext renderingContext)
    {
        return render(renderingContext);
    }
}
