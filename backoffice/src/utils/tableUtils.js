import { getUniqueKeys } from "utils/objectUtils";
import { pushIsNotPresent, isNotPresent } from "utils/arrayUtils";

export const getColumns = (content, excludeColumns = []) => {
    let columnsStrings = [];
    let columns = [];

    if (content instanceof Array) {
        for (const item of content) {
            const itemKeys = getUniqueKeys(item);
            for (const tempKey of itemKeys) {
                if (isNotPresent(tempKey, columnsStrings) && !excludeColumns.includes(tempKey)) {
                    columnsStrings = pushIsNotPresent(tempKey, columnsStrings);
                    columns = pushIsNotPresent({ name: tempKey }, columns);
                }
            }
        }
    }

    // TODO: Refactor later
    if (content instanceof Object) {
        const itemKeys = getUniqueKeys(content);
        for (const tempKey of itemKeys) {
            if (isNotPresent(tempKey, columnsStrings) && !excludeColumns.includes(tempKey)) {
                columnsStrings = pushIsNotPresent(tempKey, columnsStrings);
                columns = pushIsNotPresent({ name: tempKey }, columns);
            }
        }
    }

    return columns;
};
