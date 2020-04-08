const RulesAirBnb = require("eslint-config-airbnb-base/rules/best-practices");
const RulesCRA = require("eslint-config-react-app");

module.exports = {
    root: true,

    parser: "babel-eslint",
    parserOptions: {
        ecmaVersion: 2018,
        sourceType: "module",
        ecmaFeatures: {
            jsx: true,
            generators: true,
        },
    },

    extends: [
        "airbnb", // Baseguide is AirBnB"s
        "prettier",
        "prettier/react",
    ],

    plugins: ["prettier"],

    settings: {
        react: {
            pragma: "React",
            version: "16.3",
        },
        "import/resolver": {
            node: {
                paths: ["src"],
            },
        },
    },

    env: {
        browser: true,
        es6: true,
        jest: true,
        commonjs: false,
        node: false,
    },

    rules: {
        // -------------------------------- Merge CRA eslint with Airbnb's better defaults

        "no-restricted-properties": ["error"].concat(
            RulesAirBnb.rules["no-restricted-properties"].slice(1),
            RulesCRA.rules["no-restricted-properties"].slice(1),
        ),

        // ----------------Overrides--------
        "react/static-property-placement": "off",
        // We encourage to use class component always
        "react/prefer-stateless-function": "off",
        // Allow underscore on properties
        // original: not-present (error)
        "no-underscore-dangle": "off",
        // Don't enforce destructuring.
        // original: not-present (error)
        "react/destructuring-assignment": "warn",
        "prefer-destructuring": "warn",
        // Allows instances to not have Capitalized names.
        // original: not-present (error)
        "new-cap": "warn",
        // Don't enforce camelcasing
        // original: not-present (error)
        camelcase: "warn",
        // functions and classes can be used when hoisted, vars don't.
        // original: not-present (error)
        "no-use-before-define": [
            "error",
            {
                functions: false,
                classes: false,
            },
        ],
        // make sure there are no cycled dependencies
        // original: not-present (error: maxDepth: Infinity)
        "import/no-cycle": ["error", { maxDepth: 1 }],
        // Usability overrides.
        // original: not-present(error)
        "jsx-a11y/no-noninteractive-tabindex": "warn",
        "jsx-a11y/label-has-associated-control": "warn",
        "jsx-a11y/click-events-have-key-events": "warn",
        "jsx-a11y/no-noninteractive-tabindex": "warn",
        "jsx-a11y/no-static-element-interactions": "warn",
        "jsx-a11y/no-autofocus": "warn",
        "jsx-a11y/anchor-is-valid": "warn",
        "jsx-a11y/interactive-supports-focus": "warn",
        "jsx-a11y/no-noninteractive-element-interactions": "warn",
        "no-plusplus": ["error", { allowForLoopAfterthoughts: true }],

        // --------------------------------------------------------- Prettier overrides */

        // original: error */
        "prettier/prettier": "warn",
        // in order to keep "no-confusing-arrow" enables, allowParens has to be disabled.
        // original: not-present (both)
        allowParens: "off",
        "no-confusing-arrow": "error",
        // Always use curly braces.
        // original: not-present (prettier recommends setting this)
        curly: ["error", "all"],
        // For consinstency with jsx, always use double quotes
        // original: Patches-for-product/error
        quotes: ["off", "double"],
        // Be consistent, always write parens on arrow functions.
        // original: Patches-for-use/error (conflicted with prettier)
        "arrow-parens": ["off", "always"],
        // never force the use of newlines on properties, just be consistent,
        // original: Patches-for-us/error (conflicted with prettier)
        "object-curly-newline": [
            "off",
            {
                ObjectPattern: { minProperties: undefined, multiline: true, consistent: true },
                ObjectExpression: { minProperties: undefined, multiline: true, consistent: true },
                ImportDeclaration: { minProperties: undefined, multiline: true, consistent: true },
                ExportDeclaration: { minProperties: undefined, multiline: true, consistent: true },
            },
        ],
        // Use 4 spaces instead of AirBnb"s 2.
        // original: Patches-for-us/error (three of them conflicted with prettier)
        "react/jsx-indent": ["off", 4],
        "react/jsx-indent-props": ["off", 4],
        indent: [
            "off",
            4,
            {
                SwitchCase: 1,
                VariableDeclarator: 1,
                outerIIFEBody: 1,
                ArrayExpression: 1,
                ObjectExpression: 1,
                ImportDeclaration: 1,
                flatTernaryExpressions: false,
                ignoredNodes: ["JSXElement", "JSXElement *"],
                FunctionDeclaration: {
                    parameters: 1,
                    body: 1,
                },
                FunctionExpression: {
                    parameters: 1,
                    body: 1,
                },
                CallExpression: {
                    arguments: 1,
                },
            },
        ],
        // Maximum line-width
        // original: Patches-for-us/error (too many files to fix, changed to warning)
        "max-len": [
            "warn",
            {
                code: 120,
                ignoreComments: false,
                ignoreTrailingComments: false,
                ignoreUrls: false,
                ignoreStrings: false,
                ignoreTemplateLiterals: false,
                ignoreRegExpLiterals: false,
            },
        ],

        // ---------------------------------------------------------- Patches for project
        // This rule was deprecated and it's no longe mantained.
        "jsx-a11y/label-has-for": 0,
        // Don't require wrapping JSX in parens (to save indentation).
        "react/jsx-wrap-multilines": 0,
        "react/jsx-closing-tag-location": 0,
        // Allow padding blocks for readibility
        "padded-blocks": 0,
        // Save ourselves from ourselves, no consoles or debugger allowed in production.
        ...(process.env.NODE_ENV === "production"
            ? {
                  // Production only
                  "no-console": "error", // having console on production would be a fail.
                  "no-debugger": "error", // error doesn't cut it. This would be apocalyptical.
              }
            : {
                  // Development only
                  "no-console": "warn", // let us remember that this shouldn't be done
                  "no-debugger": "warn", // let us remember that this is beyond stupid.
              }),
    },
};
