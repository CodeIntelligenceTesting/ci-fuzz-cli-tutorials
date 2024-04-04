/**
 * @param { number } a
 * @param { number } b
 * @param { string } c
 */
module.exports = function exploreMe(a, b, c) {
	if (a >= 20000) {
		if (b >= 2000000) {
			if (b - a < 100000) {
				if (c.startsWith("@")) {
					throw new Error("Crash!");
				}
			}
		}
	}
};
